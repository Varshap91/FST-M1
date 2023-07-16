from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service = service) as driver:

    # Open the link in browser
    driver.get("https://www.training-support.net")

    print("Page Title is: " + driver.title)

    aboutUs = driver.find_element(By.ID, "about-link")
    aboutUs.click()

    print("Next Page Title is: " + driver.title)

    driver.quit()