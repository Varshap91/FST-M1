from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://training-support.net/selenium/target-practice")

    # Print page title
    print("Page Title is: " + driver.title)

    # Get 3rd header text
    h3 = driver.find_element(By.XPATH, "//h3[@id='third-header']")
    print("3rd header is: " + h3.text)

    # Get 5th header color
    h5 = driver.find_element(By.XPATH, "//h5[@class='ui green header']")
    print("5th header color: " + h5.value_of_css_property("color"))

    # Violet button classes
    violet = driver.find_element(By.XPATH, "//button[text()='Violet']")
    print("Violet button classes: " + violet.get_attribute("class"))

    # Grey button text
    grey = driver.find_element(By.XPATH, "//button[text()='Grey']")
    print("Grey button text: " + grey.text)

    driver.quit()