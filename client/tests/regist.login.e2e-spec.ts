const protractor=require('protractor');



describe('Login tests', () => {
    
    protractor.browser.manage().window().setSize(300, 300);
    protractor.browser.get('http://localhost:4200/registration');
    it('Should -------------------------', () => {
    protractor.element(protractor.by.name('username')).sendKeys('OHT7777');
    protractor.element(protractor.by.name('email')).sendKeys('OHT7777@OHT7777.com');
    protractor.element(protractor.by.name('password')).sendKeys('OHT7777');
    protractor.element(protractor.by.name('repassword')).sendKeys('OHT7777');
    
    protractor.element(protractor.by.css('#registrationForm'));
    protractor.element(protractor.by.css('#btnSubmit')).click();
    protractor.browser.sleep(5000);
    
    console.log("-------------------------------------");
    element(by.name('username')).sendKeys('OHT7777');;
    element(by.name('password')).sendKeys('OHT7777');
    element(by.css('#loginForm'));
    element(by.css('#btnSubmit')).click();
    console.log("-------------------------------------");
    expect(browser.getTitle()).toEqual('Acceuil');
   
   
});
    

});