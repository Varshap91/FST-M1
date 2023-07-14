from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://training-support.net/selenium/drag-drop")

    # Print page title
    print("Page Title is: " + driver.title)

    # Identify ball and dropzones
    football = driver.find_element(By.ID, "draggable")
    dragzone1 = driver.find_element(By.ID, "droppable")
    dragzone2 = driver.find_element(By.ID, "dropzone2")

    # perform drag and drop
    actions = webdriver.ActionChains(driver)

    actions.drag_and_drop(football, dragzone1).perform()
    message = driver.find_element(By.XPATH, "//div[@id='droppable']/p").text
    print(message)

    actions.drag_and_drop(football, dragzone2).perform()
    message = driver.find_element(By.XPATH, "//div[@id='dropzone2']/p").text
    print(message)

    driver.quit();