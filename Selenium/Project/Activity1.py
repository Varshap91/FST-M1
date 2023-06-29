# Import webdriver from selenium

from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://alchemy.hguy.co/jobs")
    pageTitle = driver.title

    # Assertion
    assert pageTitle == "Alchemy Jobs – Job Board Application"
    print("Title Validated")

    # Close the browser
    driver.quit()
