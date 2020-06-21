const protractor=require('protractor');
const by = require('protractor').by;
const element = require('protractor').element;


describe('Login tests', () => {
    
    
    protractor.browser.manage().window().setSize(800, 300);
 
    protractor.browser.get('http://localhost:4200/login');
    it('Should -------------------------', () => {
    element(by.name('username')).sendKeys('kiki');;
    element(by.name('password')).sendKeys('kiki');
    element(by.css('#loginForm'));
    element(by.css('#btnSubmit')).click();
    console.log("-------------------------------------");
    expect(browser.getTitle()).toEqual('Projects');
   
});


});