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

    dropdown = driver.find_element(By.ID, "single-select")
    dropdown_object = Select(dropdown)

    # Select the second option using the visible text
    dropdown_object.select_by_visible_text("Option 2")
    print("Second option: " + dropdown_object.first_selected_option.text)

    # Select the third option using the index
    dropdown_object.select_by_index(3)
    print("Third option: " + dropdown_object.first_selected_option.text)

    # Select the fourth option using the value
    dropdown_object.select_by_value("4")
    print("Fourth option: " + dropdown_object.first_selected_option.text)

    # Get all the options
    options = dropdown_object.options
    for opt in options:
        print(opt.text)

    driver.quit();