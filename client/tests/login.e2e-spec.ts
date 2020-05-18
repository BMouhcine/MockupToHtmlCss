import { LoginPage } from './login.po';
const browser = require('protractor').browser;

describe('Login tests', () => {
    let page: LoginPage;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateTo();
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
        page.getUsernameTextbox().sendKeys('hzg');
        page.getPasswordTextbox().sendKeys('hzg');

        page.getSubmitButton().click();

        let valLocalStorage = browser.executeScript("return window.sessionStorage.getItem('username');");
        expect(valLocalStorage).toEqual('hzg');
    //});
});