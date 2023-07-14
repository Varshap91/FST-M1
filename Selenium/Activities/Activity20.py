from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the link in browser
    driver.get("https://training-support.net/selenium/javascript-alerts")

    wait = WebDriverWait(driver, 10)

    # Print page title
    print("Page Title is: " + driver.title)

    driver.find_element(By.ID, "prompt").click()
    wait.until(expected_conditions.alert_is_present())

    prompt_alert = driver.switch_to.alert

    # Enter text
    prompt_alert.send_keys("Awesome!")

    # Close the alert
    prompt_alert.accept()
    print("User tapped on OK")

    driver.quit()