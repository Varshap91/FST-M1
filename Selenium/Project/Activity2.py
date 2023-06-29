from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://alchemy.hguy.co/jobs")

    # Get Page Heading
    pageHeading = driver.find_element(By.CLASS_NAME, "entry-title").text

    # Assertion
    assert pageHeading == "Welcome to Alchemy Jobs"
    print("Page Heading validated")

    # Close the Browser
    driver.quit()
