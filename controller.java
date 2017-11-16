package application;

import java.util.ResourceBundle;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;

public class controller implements Initializable
{
	
	@FXML
	public Sphere sphere;
	@FXML
	public Sphere sphere1;
	@FXML
	public Sphere sphere11;
	@FXML
	public Rectangle g1;
	@FXML
	public Text text;
	

	@Override
	public void initialize(URL location, ResourceBundle resource) {
			/*PhongMaterial phong = new PhongMaterial();
		    phong.setDiffuseColor(Color.RED);
		    phong.setSpecularColor(Color.RED);
			sphere.setMaterial(phong);*/
		/*Group g=new Group();
		double x=g1.getTranslateX();
		double y=g1.getTranslateY();
		double z=g1.getTranslateZ();
		MakeSphere(g,x,y,z);*/
	}
	
	private void MakeSphere(Group root,double x,double y,double z) 
	{
	    PhongMaterial phong = new PhongMaterial();
	    phong.setDiffuseColor(Color.RED);
	    phong.setSpecularColor(Color.RED);
	    
	    sphere = new Sphere(50);
	    sphere.setMaterial(phong);
	    sphere.setTranslateX(z);
	    sphere.setTranslateY(y);
	    sphere.setTranslateZ(z);

	    root.getChildren().add(sphere);
	 }
	
	@FXML
	public void displayPosition(MouseEvent e)
	{
		text.setText(e.getX()+" "+e.getY());
	}
}
