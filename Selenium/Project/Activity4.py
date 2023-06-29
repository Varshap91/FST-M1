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

    # Get Second Page Heading
    heading1 = driver.find_element(By.TAG_NAME, "h2").text

    # Assertion
    assert heading1 == "Quia quis non"
    print("Second Heading validated")

    # Close the browser
    driver.quit()