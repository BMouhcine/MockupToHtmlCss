// conf.js
exports.config = {
    framework: 'jasmine',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    specs: ['tests/login.e2e-spec.ts'],
    capabilities: {
      browserName: 'chrome',
      chromeOptions: {'args': ['--disable-web-security']}
  
  },
  }