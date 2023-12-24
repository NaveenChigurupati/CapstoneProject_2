Feature: WebDriverUniversity

@Test
Scenario: To verify iframe images are changing or not
		Given Launch chrome driver and open "http://webdriveruniversity.com/index.html" url on chrome.
		When User click on "iframe"
		And verify new tab has opened and switch to that tab.
		Then user able to see images change while clicking arrows.
	