const browser = require('protractor').browser;
const by = require('protractor').by;
const element = require('protractor').element;

export class LoginPage {
    navigateTo(){
        return browser.get('http://localhost:4200/login');
    }

    getUsernameTextbox(){
        return element(by.name('username'));
    }

    getPasswordTextbox(){
        return element(by.name('password'));
    }

    getForm(){
        return element(by.css('#loginForm'));
    }

    getSubmitButton(){
        return element(by.css('#btnSubmit'));
    }

}