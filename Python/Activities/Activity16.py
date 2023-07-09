class car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")


car1 = car("Suzuki", "Dzire", "2017", "Manual", "Red")
car2 = car("Hyundai", "i20", "2019", "Automatic", "Grey")
car3 = car("Toyota", "Innova", "2016", "Manual", "White")

car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()