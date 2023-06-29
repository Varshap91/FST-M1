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

    # Navigate to new page and get title
    driver.find_element(By.ID, "menu-item-24").click()
    jobsTitle = driver.title

    # Assertion
    assert jobsTitle == "Jobs – Alchemy Jobs"
    print("Jobs Page Title validated")

    # Close the browser
    driver.quit()