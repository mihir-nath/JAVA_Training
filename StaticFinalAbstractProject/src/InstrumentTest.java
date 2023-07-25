
public class InstrumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                   ECGMachine ecg1=new ECGMachine();
                   ecg1.use();
                   ecg1.operate();
                   ecg1.reader();
	}

}
interface Instrument
{
	void use();
}
abstract class MusicalInstrument implements Instrument
{
	abstract void play();
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument
{
	abstract void tuneStrings();
}
class Guitar extends StringBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Guitar...");
	}
	void play() {
		System.out.println("Playing Guitar...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Guitar...");

	}
	void pluck() {
		System.out.println("Plucking Strings of Guitar...");

	}
}

class lectronicGuitar extends Guitar{
	void preset() {
		System.out.println("Preseting the Electronic Guitar");
	}
}


class Violin extends StringBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Violin...");
	}
	void play() {
		System.out.println("Playing Violin...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Violin...");

	}
	void bowing() {
		System.out.println("Bowing Strings of Violin...");

	}
}

class Cello extends Violin{
	void longBowing() {
		System.out.println(" Long bowing String Of Cello");
	}
}



abstract class AirBasedMusicalInstrument extends MusicalInstrument
{
	abstract void blowAir();
}
class Flute extends AirBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Flute...");
	}
	void play() {
		System.out.println("Playing Flute...");

	}
	void blowAir() {
		System.out.println("Blowing Air in Flute...");

	}
	void whistle() {
		System.out.println("Whistling in the flute...");

	}
}


class Harmonium extends AirBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Harmonium...");
	}
	void play() {
		System.out.println("Playing Harmonium...");

	}
	void blowAir() {
		System.out.println("Blowing Air in Harmonium.");

	}
	void typing() {
		System.out.println("Typing in Harmonium..");

	}
}

abstract class DrumBasedMusicalInstrument extends MusicalInstrument
{
	abstract void tuneSurface();
}
class Tabla extends DrumBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Tabla...");
	}
	void play() {
		System.out.println("Playing Tabla...");

	}
	void tuneSurface() {
		System.out.println("Tuning surface of Tabla.");

	}
	void hittingTabla() {
		System.out.println("Hitting hands on tabla");

	}
}


class Dhol extends DrumBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Dhol...");
	}
	void play() {
		System.out.println("Playing Dhol...");

	}
	void tuneSurface() {
		System.out.println("Tuning surface of Dhol");

	}
	void hittingDhol() {
		System.out.println("Hitting hands on Dhol");

	}
}
abstract class MedicalInstrument implements Instrument
{
	abstract void operate();
}
abstract class SurgicalInstrument extends MedicalInstrument{
	abstract void sterile();
}
class SurgicalCutter extends SurgicalInstrument{
	public void use() {
		System.out.println("Using Surgical Cutter");
	}
	void operate() {
		System.out.println("Operating with Surgical Cutter");
	}
	void sterile() {
		System.out.println("steriling the Surgical Cutter");
	}
}
class SurgicalNeedle extends SurgicalInstrument{
	public void use() {
		System.out.println("Using Surgical Needle");
	}
	void operate() {
		System.out.println("Operating using Surgical Needle");
	}
	void sterile() {
		System.out.println("sterileing the Surgical Needle");
	}
}
abstract class PathologicalInstrument extends MedicalInstrument{
	abstract void reader();
}
class Glucometer extends PathologicalInstrument{
	public void use() {
		System.out.println("Using Glucometer");
	}
	void operate() {
		System.out.println("Operating using Glucometer");
	}
	void reader() {
		System.out.println("Reading taken from Glucometer");
	}
}
class ECGMachine extends PathologicalInstrument{
	public void use() {
		System.out.println("Using ECGMachine");
	}
	void operate() {
		System.out.println("Operating using ECGMachine");
	}
	void reader() {
		System.out.println("Reading taken from ECGMachine");
	}
}