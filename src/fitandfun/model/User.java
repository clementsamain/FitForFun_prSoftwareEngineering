/**
 * User Preset
 */
package fitandfun.model;

import java.time.LocalDate;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Viki
 * @version 0.1
 */
public class User {
    
    /**
     * User data
     */
    private final StringProperty username;
    private final ObjectProperty<LocalDate> birthday;
    // WEIGHT in kg 
    private final FloatProperty weight;
    // HEIGHT in cm
    private final IntegerProperty height;
    private final StringProperty sex;
    private final FloatProperty BMI;
    
    /**
     * Constructor
     */
    
    public User()
    {
        this(null, null);
    }
    
    public User(String username, String sex)
    {
        this.username = new SimpleStringProperty(username);
        this.sex = new SimpleStringProperty(sex);
        this.birthday = null;
        this.weight = new SimpleFloatProperty(0);
        this.height = new SimpleIntegerProperty(0);
        this.BMI = new SimpleFloatProperty(0);
    }
    
    public User(String username, String sex, LocalDate birthday)
    {
        this.username = new SimpleStringProperty(username);
        this.sex = new SimpleStringProperty(sex);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.weight = new SimpleFloatProperty(0);
        this.height = new SimpleIntegerProperty(0);
        this.BMI = new SimpleFloatProperty(0);
    }
    
    public User(String username, String sex, LocalDate birthday, float w, int h)
    {
        this.username = new SimpleStringProperty(username);
        this.sex = new SimpleStringProperty(sex);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.weight = new SimpleFloatProperty(w);
        this.height = new SimpleIntegerProperty(h);
        this.BMI = new SimpleFloatProperty(0);
        updateBMI();
    }
    
    
    /*
     * Get- and Set-Methods
     */
    
    public String getUsername()
    {
        return username.get();
    }
    
    public void setUsername(String username)
    {
        this.username.set(username);
    }
    
    public LocalDate getBirthday()
    {
        return birthday.get();
    }
    
    public void setBirhtday(LocalDate birthday)
    {
        this.birthday.set(birthday);
    }
    
    public float getWeight()
    {
        return weight.get();
    }
    
    public void setWeight(float weight)
    {
        this.weight.set(weight);
    }
    
    public int getHeight()
    {
        return height.get();
    }
    
    public void setHeight(int height)
    {
        this.height.set(height);
    }
    
    /**
     * Update BMI when values are available
     */
    private void updateBMI()
    {
    	this.BMI.set(weight.get() / (height.get() * height.get()));
    }
}
