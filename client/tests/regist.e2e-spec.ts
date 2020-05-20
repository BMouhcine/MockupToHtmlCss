const protractor=require('protractor');



describe('Registration test', () => {
    
    protractor.browser.manage().window().setSize(300, 300);
    protractor.browser.get('http://localhost:4200/registration');
    it('Should -------------------------', () => {
    protractor.element(protractor.by.name('username')).sendKeys('OHT77777');
    protractor.element(protractor.by.name('email')).sendKeys('OHT7777@OHT77777.com');
    protractor.element(protractor.by.name('password')).sendKeys('OHT77777');
    protractor.element(protractor.by.name('repassword')).sendKeys('OHT77777');
    
    protractor.element(protractor.by.css('#registrationForm'));
    protractor.element(protractor.by.css('#btnSubmit')).click();
    protractor.browser.sleep(5000);
    console.log("-------------------------------------");
    expect(browser.getTitle()).toEqual('Login');
   
   
});
    

});