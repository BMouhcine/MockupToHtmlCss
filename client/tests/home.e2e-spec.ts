//require('protractor').browser;
const browser = require('protractor').browser
describe('My App', function() {
  it('should hit the VM hosted site', function() {
      browser.get('http://localhost:4200/');

      //Write tests here
      //element(by.model('toolbar-btn-on')).sendKeys('write first app test');
      //element(by.css

      //Test to get app title:
      expect(browser.getTitle()).toEqual('AngularMockupToHtml');
  });
});