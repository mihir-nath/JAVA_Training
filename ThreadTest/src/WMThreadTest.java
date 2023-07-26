
public class WMThreadTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WashingPowder washPowder = new WashingPowder(100,"Nirma", "Front Load", true, 10.0f);
		System.out.println("Wash Powder : "+washPowder); //toString is invoked
		
		Water water = new Water("Cold", 40, "20°C"); 
		System.out.println("Water : "+water); 
		
		Electricity electricity = new Electricity("AC", 220.0f, 8, 15, "Mahavitaran");
		System.out.println("Electricity : "+electricity);
		
		Cloth[] clothes = new Cloth[5];
		clothes[0] = new Cloth("Cotton", "Blue", 250.99f, "T-Shirt", false);
		clothes[1] = new Cloth("Polyester", "Red", 390.99f, "Dress", true);
		clothes[2] = new Cloth("Denim", "Black", 340.99f, "Jeans", false);
		clothes[3] = new Cloth("Silk", "Green", 190.99f, "Bath Towel", false);
		clothes[4] = new Cloth("Linen", "White", 290.99f, "Pants", true);
		
		int i=0; 
		for (Cloth cloth : clothes) {
			System.out.println("cloth" + ++i + " : "+   cloth);
        }
		
		System.out.println("================================================\n");
  

		
		try {
			//WashingMachine washingMachine = new WashingMachine();
			WashingMachine washingMachine1= new WashingMachine("LG",washPowder, water, electricity, clothes);
			WashingMachine washingMachine2= new WashingMachine("Samung",washPowder, water, electricity, clothes);
			WashingMachine washingMachine3= new WashingMachine("Godrej",washPowder, water, electricity, clothes);


			washingMachine1.start();
			washingMachine2.start();
			washingMachine3.start();
			Laundry laundry = washingMachine1.wash(washPowder, water, electricity, clothes);
			
			System.out.println("Number of Clothes : " + laundry.getNumberOfCloths());
			System.out.println("Time Required to wash clothes : " + laundry.getTimeRequired() + " mins");
			System.out.println("Total Cost of Clothes : " + laundry.getentireCost() + " Rs");
			System.out.println("Water Used for washing clothes : " + laundry.getWaterUsed() + " L");
			System.out.println("Electricity Used for washing clothes : " + laundry.getElectricityUsed() + " kWh");
			System.out.println("Cost of Washing Powder: " + laundry.getCostOfWashingPowder() + " Rs");
			
            Laundry laundry1 = washingMachine2.wash(washPowder, water, electricity, clothes);
			
			System.out.println("Number of Clothes : " + laundry1.getNumberOfCloths());
			System.out.println("Time Required to wash clothes : " + laundry1.getTimeRequired() + " mins");
			System.out.println("Total Cost of Clothes : " + laundry1.getentireCost() + " Rs");
			System.out.println("Water Used for washing clothes : " + laundry1.getWaterUsed() + " L");
			System.out.println("Electricity Used for washing clothes : " + laundry1.getElectricityUsed() + " kWh");
			System.out.println("Cost of Washing Powder: " + laundry1.getCostOfWashingPowder() + " Rs");
		} catch (WaterNotAvailable ex1) {
			// TODO Auto-generated catch block
			System.out.println("Water Problem"+ex1);
		}
		 
	}

}

class WashingMachine extends Thread { //isA
	
//	WashingTub washTub = new WashingTub(); //hasA
         boolean waterAvailable=false;
         String WashingMachineBrand;
         WashingPowder washPowder;
  	     Water water;
  	     Electricity electricity;
	     Cloth clothes[];
  	     public WashingMachine(String washingMachineBrand, WashingPowder washPowder, Water water,
				Electricity electricity, Cloth[] clothes) throws WaterNotAvailable {
			super();
			WashingMachineBrand = washingMachineBrand;
			this.washPowder = washPowder;
			this.water = water;
			this.electricity = electricity;
			this.clothes = clothes;
			 double value = Math.random()%10;
        	 if(value>0.30) {
        		 waterAvailable=true;
        	 }
        	 if(waterAvailable==true) {
     			System.out.println("Water is Available ..use..Wahing  Machine..");
     			
     		}
     		else {
     			//System.out.println("Car Key Not Found....");
     			throw new WaterNotAvailable("Water Not Available....Wash Later");
     			
     		}
		}
		
	
		Laundry wash(WashingPowder washPowder, Water water, Electricity electricity, Cloth clothes[]) {
			
			double value = Math.random()%10;
			if(value>0.66) {
				ElectricityGoneException ex2 = new ElectricityGoneException("Oh No!!! Electricity Gone..Wait....");
				throw ex2;
			}
			Laundry laundry = new Laundry();
			laundry.setNumberOfCloths(clothes.length);
			float timeRequired = 60.00f; 
			laundry.setTimeRequired(timeRequired);
			 float entireCost = 0.0f;
		        for (Cloth cloth : clothes) {
		            entireCost += cloth.getCost();
		        }
			laundry.setentireCost(entireCost);
			laundry.setWaterUsed((float)water.getQuantity());
			
			float electricityUsed = electricity.getUnitUsed() * (timeRequired / 60.0f);
			laundry.setElectricityUsed(electricityUsed);
			laundry.setCostOfWashingPowder(washPowder.getPrice() * ((float)water.getQuantity() + electricityUsed));
			
			return laundry;
		}
		public void run() {
			wash(washPowder, water, electricity, clothes);
		}
}

class Laundry {
	private int numberOfCloths; //cloth.length
	private float timeRequired;
	private float entireCost ;// cloth.length * price per cloth
	private float waterUsed;
	private float electricityUsed;
	private float costOfWashingPowder; //
	
	public Laundry() {
		
	}
	public Laundry(int numberOfCloths, float timeRequired, float entireCost, float waterUsed, float electricityUsed,
			float costOfWashingPowder) {
		super();
		this.numberOfCloths = numberOfCloths;
		this.timeRequired = timeRequired;
		this.entireCost = entireCost;
		this.waterUsed = waterUsed;
		this.electricityUsed = electricityUsed;
		this.costOfWashingPowder = costOfWashingPowder;
	}

	@Override
	public String toString() {
		return "Laundry [numberOfCloths=" + numberOfCloths + ", timeRequired=" + timeRequired + ", entireCost="
				+ entireCost + ", waterUsed=" + waterUsed + ", electricityUsed=" + electricityUsed
				+ ", costOfWashingPowder=" + costOfWashingPowder + "]";
	}

	public int getNumberOfCloths() {
		return numberOfCloths;
	}

	public void setNumberOfCloths(int numberOfCloths) {
		this.numberOfCloths = numberOfCloths;
	}

	public float getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}

	public float getentireCost() {
		return entireCost;
	}

	public void setentireCost(float entireCost) {
		this.entireCost = entireCost;
	}

	public float getWaterUsed() {
		return waterUsed;
	}

	public void setWaterUsed(float waterUsed) {
		this.waterUsed = waterUsed;
	}

	public float getElectricityUsed() {
		return electricityUsed;
	}

	public void setElectricityUsed(float electricityUsed) {
		this.electricityUsed = electricityUsed;
	}

	public float getCostOfWashingPowder() {
		return costOfWashingPowder;
	}

	public void setCostOfWashingPowder(float costOfWashingPowder) {
		this.costOfWashingPowder = costOfWashingPowder;
	}
	
}

class Tub {
	
}

class WashingTub{
	private int capacity;
	private String type; //
	public WashingTub(int capacity, String type) {
		super();
		this.capacity = capacity;
		this.type = type;
	}
	@Override
	public String toString() {
		return "WashingTub [capacity=" + capacity + ", type=" + type + "]";
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

class Powder {
	
}

class WashingPowder{ // isA

	private int quantity; // in grams
	private String brand;
	private String type;
	private boolean scented;
	private float price; // in rupees
	
	public WashingPowder(int quantity, String brand, String type, boolean scented, float price) {
		super();
		this.quantity = quantity;
		this.brand = brand;
		this.type = type;
		this.scented = scented;
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "WashingPowder [quantity=" + quantity + ", brand=" + brand + ", type=" + type + ", scented=" + scented
				+ ", price=" + price + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isScented() {
		return scented;
	}

	public void setScented(boolean scented) {
		this.scented = scented;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

class Water {
	private String type;
	private int quantity; // in liters
	private String temperature; // in deg Celsius
	
	public Water(String type, int quantity, String temperature) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Water [type=" + type + ", quantity=" + quantity + "L, temperature=" + temperature + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}

class Electricity {
	private String type; //ac dc
	private float voltage; // volts
	private int costPerUnit;
	private int unitUsed; // kWh
	private String supplier;
	
	public Electricity(String type, float voltage, int costPerUnit, int unitUsed, String supplier) {
		super();
		this.type = type;
		this.voltage = voltage;
		this.costPerUnit = costPerUnit;
		this.unitUsed = unitUsed;
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Electricity [type=" + type + ", voltage=" + voltage + "V, costPerUnit=" + costPerUnit + ", unitUsed="
				+ unitUsed + "units, supplier=" + supplier + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public int getUnitUsed() {
		return unitUsed;
	}
	public void setUnitUsed(int unitUsed) {
		this.unitUsed = unitUsed;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
	
}

class Cloth {
	private String material; //
	private String color;
	private float cost;
	private String type;
	private boolean clean; //
	
	public Cloth(String material, String color, float cost, String type, boolean clean) {
		super();
		this.material = material;
		this.color = color;
		this.cost = cost;
		this.type = type;
		this.clean = clean;
	}
	@Override
	public String toString() {
		return "Cloth [material=" + material + ", color=" + color + ", cost=" + cost + ", type=" + type + ", clean="
				+ clean + "]";
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isClean() {
		return clean;
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
}
class WaterNotAvailable extends Exception{
	WaterNotAvailable(String msg) {
		super(msg);
	}
}
class ElectricityGoneException extends RuntimeException{
	ElectricityGoneException(String msg) {
		super(msg);
	}
}