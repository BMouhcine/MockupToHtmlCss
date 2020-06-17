package com.project.mockup2html.Controllers;


import java.io.IOException;
import java.util.HashMap;

import javax.imageio.IIOImage;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.project.mockup2html.Models.ImageUI;
import com.project.mockup2html.Models.User;
import com.project.mockup2html.Repositories.ImageUIRepository;
import com.project.mockup2html.Repositories.UserRepository;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import nu.pattern.OpenCV;
import sun.tools.jar.resources.jar;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ImageController {
	@Autowired
	ImageUIRepository imageUIRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@PostMapping(value = "/doUploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImageHandler(@RequestParam MultipartFile givenImage, @RequestParam long user_id) throws IOException {
        System.out.println("File name"+givenImage.getOriginalFilename()+" uploaded successfully by "+user_id+".");
        if(UserController.currentUserId!=-1) {
        	User userBuffer = userRepository.findById(UserController.currentUserId).get();
        	OpenCV.loadShared();
            imageUIRepository.save(new ImageUI(givenImage.getBytes(),userBuffer));
            java.util.Map<String, Integer> imgMap = new HashMap<>();
            Mat imgMat = loadImage(givenImage);
            imgMap.put("height", Integer.valueOf((int) imgMat.size().height));
            imgMap.put("width", Integer.valueOf((int) imgMat.size().width));
            imgMap.put("depth",imgMat.channels());
            String dataString = JSONObject.toJSONString(imgMap);
            //String dataString= String.valueOf(imgMat.size().width)+" : "+String.valueOf(imgMat.size().height)+"\n Path: "+ this.getClass().getClassLoader().getResource("static/assets/upload-icon.png").getFile();
            return ResponseEntity.ok().body(dataString);
        }
        return ResponseEntity.ok().body(null);
    }
	
	
	public static Mat loadImage(MultipartFile givenImage) throws IOException {
		Mat imgMat = Imgcodecs.imdecode(new MatOfByte(givenImage.getBytes()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
		imgMat = imgPreprocessing(imgMat);
	    return imgMat;
	}
	public static Mat imgPreprocessing(Mat imgMat) {
		Mat grayImgMat = new Mat();
		Mat imgAdaptedMat = new Mat();
		Mat imgStackedMat = new Mat();
		Mat imgResizedMat = new Mat();
		Mat bgImg = new Mat();
		Imgproc.cvtColor(imgMat, grayImgMat, Imgproc.COLOR_RGB2GRAY);
		Imgproc.adaptiveThreshold(grayImgMat, imgAdaptedMat, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 101, 9);
		Core.repeat(imgAdaptedMat, 3, 3, imgStackedMat);
		Imgproc.resize(imgStackedMat, imgResizedMat, new Size(200, 200), 200, 200, Imgproc.INTER_AREA);
		Mat bgImgMat = Mat.ones(256, 256, CvType.CV_16U);Core.repeat(bgImgMat, 3, 3, bgImg);
		
		Core.multiply(bgImg, new Scalar(255, 255, 255), bgImg);
		Core.multiply(imgResizedMat, bgImg, imgResizedMat);
		/*
		 *  for(int i=27;i<227;i++) {
		 * for(int j=27;j<227;j++) { bgImg.put(i, j, imgResizedMat.get(i-27, j-27)); } }
		 * Core.divide(bgImg,new Scalar(255, 255, 255), bgImg);
		 */
		
		
		return bgImg;
	}
	
}