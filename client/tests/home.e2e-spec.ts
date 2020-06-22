//require('protractor').browser;
const browser = require('protractor').browser
describe('My App', function() {
  it('should hit the VM hosted site', function() {
      browser.get('http://localhost:4200/');

      expect(browser.getTitle()).toEqual('AngularMockupToHtml');
  });
});