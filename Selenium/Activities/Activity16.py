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
    driver.get("https://training-support.net/selenium/dynamic-attributes")

    wait = WebDriverWait(driver, 10)

    # Print page title
    print("Page Title is: " + driver.title)

    # Enter details and sign up
    driver.find_element(By.XPATH, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[1]/input").send_keys("Varshap11")
    driver.find_element(By.XPATH, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/input").send_keys("1234567")
    driver.find_element(By.XPATH, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[3]/input").send_keys("1234567")
    driver.find_element(By.XPATH, "//input[@type='email']").send_keys("varshap11@text.com")
    driver.find_element(By.XPATH, "/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/button").click()

    # Confirm login msg
    loginMsg = driver.find_element(By.ID, "action-confirmation")
    wait.until(expected_conditions.element_to_be_clickable(loginMsg))
    print("Loin message: " + loginMsg.text)

    # close the browser
    driver.quit()