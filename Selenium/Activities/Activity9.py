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
    driver.get("https://training-support.net/selenium/ajax")

    # Print page title
    print("Page Title is: " + driver.title)

    wait = WebDriverWait(driver, 10)

    driver.find_element(By.CSS_SELECTOR, "button.ui:nth-child(2)").click()
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
    hello = driver.find_element(By.TAG_NAME, "h1").text
    print(hello)

    delayedText = driver.find_element(By.TAG_NAME, "h3")
    print(delayedText.text)

    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    helloMsg = driver.find_element(By.TAG_NAME, "h3").text
    print(helloMsg)

    driver.quit();
