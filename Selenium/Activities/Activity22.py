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
    driver.get("https://www.training-support.net/selenium/popups")

    wait = WebDriverWait(driver, 10)

    # Print page title
    print("Page Title is: " + driver.title)

    # Sign in button
    signIn = driver.find_element(By.CSS_SELECTOR, ".inverted")
    msg = signIn.get_attribute("data-tooltip")
    print(msg)
    signIn.click()

    # Enter the credentials
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.implicitly_wait(20)
    driver.find_element(By.XPATH, "//button[text()='Log in']").click()

    loginMsg = driver.find_element(By.ID, "action-confirmation")
    print("Login Message: " + loginMsg.text)

    driver.quit()