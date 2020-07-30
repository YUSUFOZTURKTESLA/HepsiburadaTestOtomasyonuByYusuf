/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme2;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Recai
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ChoiceBox choiceBox_Browser;
    
    @FXML
    private ChoiceBox choiceBox_cinsiyet;
    
    @FXML
    private TextField tf_Email;
    
    @FXML
    
    private TextField tf_isim;;
    
    @FXML
    private TextField tf_soyisim;
    
    @FXML
    private TextField pf_sifre;
    
    @FXML
    private TextField tf_phone;
    
    @FXML
    private TextField tf_gunTarih;
    
    @FXML
    private TextField tf_ayTarih;
    
    @FXML
    private TextField tf_yilTarih;
    
    @FXML
    private TextField tf_adres;
    
    @FXML
    private TextField tf_sehir;
    
    @FXML
    private TextField tf_postaKodu;
    
    @FXML
    private TextArea textArea;
    
    
    
    
    
    
    
    @FXML
    private void testiBaslatAction(ActionEvent event) {
        System.out.println("Butona Tıklandı!");
        //label.setText("Hello World!");
        
        
        SeleniumTest();
  
    }
    
   private static  WebDriver driver = null;
   
   private void SeleniumTest(){
       
       
       //Browser Secimi
       String browser=null;       
       browser=chooseBrowser((String) choiceBox_Browser.getValue());
       
       if(browser=="Chrome"){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32 (1)\\chromedriver.exe");
        driver =new ChromeDriver();
       }
       else if(browser=="Firefox"){
        System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        driver =new FirefoxDriver();   
       }
       
              
        
        driver.get("http://automationpractice.com/index.php");
        
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click(); // Sign Tikliyoruz
        
        //Burada  1-3 saniye bekletiyoruz elmentlerin full dolması icin
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        //email adresimizi textFielde giriyoruz
        WebElement mailTextField = driver.findElement(By.id("email_create"));
        mailTextField.click();
        mailTextField.sendKeys(tf_Email.getText());
        
        //Create account butonuna tıklıyoruz
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        
        
        
        try {
            
            //isim girilcek              
            WebElement firstNameTextField = driver.findElement(By.name("customer_firstname"));
            firstNameTextField.click();           
            firstNameTextField.sendKeys(tf_isim.getText());
            
            //soyisim girilcek
            WebElement lastNametextField = driver.findElement(By.name("customer_lastname"));
            lastNametextField.click();           
            lastNametextField.sendKeys(tf_soyisim.getText());
            
            //password girilcek
            WebElement passwordtextField = driver.findElement(By.name("passwd"));
            passwordtextField.click();           
            passwordtextField.sendKeys(pf_sifre.getText());
            
            //tarih gun girilcek
            WebElement dayTextField = driver.findElement(By.id("days"));
            dayTextField.click();           
            dayTextField.sendKeys(tf_gunTarih.getText());
            dayTextField.click();  
            
            //tarih ay girilcek  --- sitede ingilizce kelimelerle gosterilmis ama zorunlu degil b uyuzden es gecebiliriz
            WebElement monthTextField = driver.findElement(By.id("months"));
            monthTextField.click();           
            monthTextField.sendKeys(tf_ayTarih.getText());
            monthTextField.click(); 
            
            //tarih yıl girilcek
            WebElement yearTextField = driver.findElement(By.id("years"));
            yearTextField.click();           
            yearTextField.sendKeys(tf_yilTarih.getText());
            yearTextField.click(); 
            
            //adres girilcek
            WebElement adressTextField = driver.findElement(By.id("address1"));
            adressTextField.click();           
            adressTextField.sendKeys(tf_adres.getText());
            adressTextField.click(); 
            
            //sehir girilcek
            WebElement sehirTextField = driver.findElement(By.id("city"));
            sehirTextField.click();           
            sehirTextField.sendKeys(tf_sehir.getText());
            sehirTextField.click(); 
            
            //eyalet default oalrak girecez (Alabama) zorunlu istiyor bizden cunku
            WebElement stateTextField = driver.findElement(By.id("id_state"));
            stateTextField.click();           
            stateTextField.sendKeys("Alabama");
            stateTextField.click(); 
            
            //posta kodu girilecek
            WebElement postCodeTextField = driver.findElement(By.id("postcode"));
            postCodeTextField.click();           
            postCodeTextField.sendKeys(tf_postaKodu.getText());
            postCodeTextField.click(); 
            
            //telefon girilecek
            WebElement phoneTextField = driver.findElement(By.id("phone"));
            phoneTextField.click();           
            phoneTextField.sendKeys(tf_phone.getText());
            phoneTextField.click(); 
            
            //Kullaniciyi Ekliyoruz (Register Butonuna tıklıyoruz)
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WebElement registerButton = driver.findElement(By.id("submitAccount"));
            registerButton.click();  
            
            
            //Kullanıcı girisi yapıldıktan sonra
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            String textKullaniciAdi  = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")).getText();
            System.out.println(textKullaniciAdi +"Oturumu basariyla acıldı");
            
            
            //Dressers e tıklıyoruz
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            WebElement dressesButton  = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
            dressesButton.click();
            
            //Summer dresses a tıklıyoruz
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement summerdressesButton  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[3]/a"));
            summerdressesButton.click();
            
            //summer dress ilk urunu ekliyoruz
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement addCartButton  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
            addCartButton.click();
            
            //ekledikten sonra alısverise dewam
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement continueButton  = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span"));
            continueButton.click();
            
            //Summer urun araması
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement searchBar  = driver.findElement(By.id("search_query_top"));
            searchBar.click();
            searchBar.sendKeys("Summer");
            
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            WebElement submitSearchButton  = driver.findElement(By.name("submit_search"));
            submitSearchButton.click();
            
            //Urun aramasından secilen uurunun eklenmesi
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement addCardButton2  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[4]/div/div[2]/div[2]/a[1]/span"));
            addCardButton2.click();
            
            //ekledikten sonra alısverise dewam2
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement continueButton2  = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span"));
            continueButton2.click();
            
            //cart-check urun dogrulama
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement cartButton  = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/b"));
            cartButton.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //process to check out
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement processButton  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span"));
            processButton.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //process to check out adres seciminden sonra
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement processButton2  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"));
            processButton2.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //teams of service kabul edilmesi
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement toggle1  = driver.findElement(By.id("cgv"));
            toggle1.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //process to check out 3(toggle dan sonraki)
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement processButton3  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span"));
            processButton3.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //Pay bank by vire secimi
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement payBankButton  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a"));
            payBankButton.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //I confirm my order 
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement confirmButton  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"));
            confirmButton.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //kullanici Kismi
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement userButon  = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span"));
            userButon.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            //Order History and Details Kismi
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement orderHistoryButton  = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[1]/a/span"));
            orderHistoryButton.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            
            
            
            //Rapor Gosterimi
            
            Alert alert = new Alert(AlertType.INFORMATION, 
                    "-"+tf_isim.getText()+" "+tf_soyisim.getText() +" "+ "Kullanicisi olusturuldu ve girişi Yapildi" +"\n"
                            
                    +"-SummerDresses kısmından bir ürün sepete eklendi"+"\n"
                    +"-Summer ürün araması sonucundan 1 ürün carta eklendi"+"\n"
                    +"-Cart>Check Out ile Sepet görüntülendi ve ürünler doğrulandı"+"\n"
                    +"-Adres Seçimi gerçekleştirildi"+"\n"
                    +"-Kargo seçeneği ve hizmet Şartları kabul edildi"+"\n"
                    +"-İlk ödeme yöntemi seçilerek alışveriş tamamlandı"+"\n"
                    +"-Order history and details sayfası kontrol edildi"
                    
                    
            , ButtonType.OK);
            alert.showAndWait();

              if (alert.getResult() == ButtonType.OK) {
              //do stuff
              driver.quit();
              }
            
            
            
            
            
            
            
            
            
           
       } catch (Exception e) {
           
        String text = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]/ol/li")).getText();
        System.out.println(text);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
            if(text != null){
            
            //email adresi kullanılıyor hatası verilip basa yonlendirilecek
            
            Alert alert = new Alert(AlertType.ERROR, "Bu email adresi kullanılmakta ve ya yanlış Lutfen baska bir tane deneyin" , ButtonType.OK);
            alert.showAndWait();

              if (alert.getResult() == ButtonType.OK) {
              //do stuff
              driver.quit();
              }
        }
       }
        


    }
   
    ObservableList<String> list =FXCollections.observableArrayList("Chrome","Firefox");

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
   
     choiceBox_Browser.setItems(list);
        
    }    
    
    private String chooseBrowser(String browserName){
        String name = null;
        if(browserName=="Chrome")
            name= "Chrome";
        if(browserName=="Firefox")
            name= "Firefox";
            
      return name;
    }
    

    
}
