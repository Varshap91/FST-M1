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

    # Get Image URL
    image = driver.find_element(By.CSS_SELECTOR, ".attachment-large")
    print("Image url is:" + image.get_attribute("src"))

    # CLose the browser
    driver.quit()