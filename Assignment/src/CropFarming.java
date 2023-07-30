

public class CropFarming {
   public static void main(String[] args) {
	   
	RiceFarmer rf1=new RiceFarmer("Ramesh", "Ravi", 5, 10, 5000.0f, 500.0f, 2000.0f);
	rf1.start();
}
}

interface Farmer{
	Crop farming(RiceFarmer.RiceFarmingDetail x,RiceFarmer y,Rate z);
}
class RiceFarmer extends Thread implements Farmer{
	
	private String farmerName;
	private String nameOfCrop;
	private float landArea;
	
	RiceFarmingDetail riceDetail=new RiceFarmingDetail();
	
	
	
	

	public RiceFarmer(String farmerName, String nameOfCrop, float landArea, int quantityOfSeed,float tractorCost,float pasticideCost,float fartilizerCost) {
		super();
		this.farmerName = farmerName;
		this.nameOfCrop = nameOfCrop;
		this.landArea = landArea;
		riceDetail.setQuantityOfSeed(quantityOfSeed);
		riceDetail.setTractorCost(tractorCost);
		riceDetail.setFartilizerCost(fartilizerCost);
		riceDetail.setPesticideCost(pasticideCost);
		
	}

	class RiceFarmingDetail{
		private int quantityOfSeed;
		private boolean irrigation;
		private float tractorCost;
		private float pesticideCost;
		private float fartilizerCost;
		
		public int getQuantityOfSeed() {
			return quantityOfSeed;
		}
		public void setQuantityOfSeed(int quantityOfSeed) {
			this.quantityOfSeed = quantityOfSeed;
		}
		public boolean getIrrigation() {
			return irrigation;
		}
		public void setIrrigation(boolean irrigation) {
			this.irrigation = irrigation;
		}
		public float getTractorCost() {
			return tractorCost;
		}
		public void setTractorCost(float tractorCost) {
			this.tractorCost = tractorCost;
		}
		public float getPesticideCost() {
			return pesticideCost;
		}
		public void setPesticideCost(float pesticideCost) {
			this.pesticideCost = pesticideCost;
		}
		public float getFartilizerCost() {
			return fartilizerCost;
		}
		public void setFartilizerCost(float fartilizerCost) {
			this.fartilizerCost = fartilizerCost;
		}
		public float riceGrown() {
			  float totalRiceGrown;
			  totalRiceGrown = riceDetail.getQuantityOfSeed() *25;
			  return totalRiceGrown;
			  
		}
		
		
		public float cost() {
			float costOfFarming;
			costOfFarming=riceDetail.getFartilizerCost()+riceDetail.getPesticideCost()+riceDetail.getTractorCost();
			return costOfFarming;
		}
		
		
	}
	
	
	
	public Crop farming(RiceFarmingDetail riceDetail,RiceFarmer riceFarmer,Rate rate) {
		Crop crop=new Crop( riceDetail.riceGrown(),riceDetail.cost());
		float totalMoney= riceDetail.riceGrown()*rate.rateOfRice;
		crop.setMoneyFromCrop(totalMoney);
		crop.setTotalQuantity(riceDetail.riceGrown());
		
		return crop;
	}
	
	public void run() {
		Rate rate=new Rate();
		
		for(int i=0;i<=90;i++) {
			System.out.println(this.farmerName+"is farming"+this.nameOfCrop+"--day"+i);
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		Crop crp= farming(this.riceDetail, this, rate);
		System.out.println("Total"+crp.getTotalQuantity()+"KG of rice grown and the Farmer earned RS"+crp.getMoneyFromCrop());
	}

	/*@Override
	public Crop farming(RiceFarmer x, Rate y) {
		// TODO Auto-generated method stub
		return null;
	}*/
}





class Rate{
	public static final float rateOfRice=30.0f;
}
class Crop{
	private float totalQuantity;
	private float moneyFromCrop; 
	Crop(){
		
	}
	public Crop(float totalQuantity, float moneyFromCrop) {
		super();
		this.totalQuantity = totalQuantity;
		this.moneyFromCrop = moneyFromCrop;
	}
	public float getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(float totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public float getMoneyFromCrop() {
		return moneyFromCrop;
	}
	public void setMoneyFromCrop(float moneyFromCrop) {
		this.moneyFromCrop = moneyFromCrop;
	}
	
     
}
