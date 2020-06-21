const protractor=require('protractor');
const by = require('protractor').by;
const element = require('protractor').element;
const remote = require('protractor/node_modules/selenium-webdriver/remote');
const path = require('path');

describe('Image Upload test ', () => {
    
    
    protractor.browser.manage().window().setSize(1200, 300);
 
    protractor.browser.get('http://localhost:4200/login');
    it('Should -------------------------', () => {
    element(by.name('username')).sendKeys('kiki');;
    element(by.name('password')).sendKeys('kiki');
    element(by.css('#loginForm'));
    element(by.css('#btnSubmit')).click();
    
    expect(browser.getTitle()).toEqual('Projects');
    browser.driver.sleep(4000);
    element(by.css('#upload')).click();
    expect(browser.getTitle()).toEqual('Acceuil');
    browser.setFileDetector(new remote.FileDetector());
    var fileToUpload = './images/1.jpg';
    var absolutePath = path.resolve(__dirname, fileToUpload);
    var fileElem = element(by.css('input[type="file"]'));
    fileElem.sendKeys(absolutePath);
    element(by.css('button[class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left"]')).click(); // does post request
    browser.driver.sleep(4000);
    console.log("-------------------------------------");
    expect(browser.getTitle()).toEqual('Projects');
});


});