from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the link in browser
    driver.get("https://training-support.net/selenium/selects")

    # Print page title
    print("Page Title is: " + driver.title)

    dropdown = driver.find_element(By.ID, "multi-select")
    dropdown_object = Select(dropdown)

    # Select the "JavaScript" option
    dropdown_object.select_by_visible_text("Javascript")
    print("Text selected: " + dropdown_object.first_selected_option.text)

    # Select the 4th, 5th and 6th options
    dropdown_object.select_by_index(5)
    dropdown_object.select_by_index(6)
    dropdown_object.select_by_index(7)

    # Select the "NodeJS" option
    dropdown_object.select_by_value("node")
    print("Text selected: " + dropdown_object.first_selected_option.text)

    # Deselect the 5th option using index.
    dropdown_object.deselect_by_index(6)

    driver.quit()