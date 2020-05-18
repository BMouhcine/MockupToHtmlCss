const protractor=require('protractor');
const by = require('protractor').by;
const element = require('protractor').element;


describe('Login tests', () => {
    
    
    protractor.browser.manage().window().setSize(800, 300);
 
    protractor.browser.get('http://localhost:4200/login');
    it('Should -------------------------', () => {
    element(by.name('username')).sendKeys('hzg');;
    element(by.name('password')).sendKeys('hzg');
    element(by.css('#loginForm'));
    element(by.css('#btnSubmit')).click();
    //protractor.browser.sleep(5000);
    console.log("-------------------------------------");
    expect(browser.getTitle()).toEqual('Acceuil');
    //protractor.browser.wait(protractor.until.elementIsVisible(hzg), 5000, 'Error: Element did not display within 5 seconds');
    //let valLocalStorage = 
    
    
    //console.log(valLocalStorage);
    //console.log(valLocalStorage);
   // expect(valLocalStorage).toEqual('hzg');
});


    /*it('Login form should be valid', () => {
        page.getUsernameTextbox().sendKeys('hzg');
        page.getPasswordTextbox().sendKeys('hzg');

        let form = page.getForm().getAttribute('class');

        expect(form).toContain('ng-valid');
    });

    it('Login form should be invalid', () => {
        page.getUsernameTextbox().sendKeys('');
        page.getPasswordTextbox().sendKeys('');

        let form = page.getForm().getAttribute('class');

        expect(form).toContain('ng-invalid');
    });*/

    //it('Should set email value to local storage', () => {
        

        

       
    //});
});