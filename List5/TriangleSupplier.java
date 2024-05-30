 import javafx.scene.paint.Color;

 /**
  * @brief Provides methods to create instances of DrawableTriangle based on DrawableObjectData.
  */
 public class TriangleSupplier implements DrawableObjectSupplier {
 
     /**
      * @brief Creates a DrawableTriangle based on the provided DrawableObjectData.
      * @param data The DrawableObjectData containing information to create the DrawableTriangle.
      * @return The created DrawableTriangle object.
      * @throws IllegalArgumentException if the type specified in the DrawableObjectData does not match "Triangle".
      */
     public Drawable get(DrawableObjectData data) throws IllegalArgumentException {
         if (!data.type.equals("Triangle")) {
             throw new IllegalArgumentException("Wrong type of Drawable object, expected Triangle, got " + data.type);
         }
 
         // Create a DrawableTriangle object
         Drawable triangle = new DrawableTriangle(0, data.height * 0.5, data.width * 0.5, -data.height * 0.5, -data.width * 0.5, -data.height * 0.5);
         
         // Set properties based on the data
         triangle.setTranslateX(data.translateX);
         triangle.setTranslateY(data.translateY);
         triangle.setWidth(data.width * data.scaleX);
         triangle.setHeight(data.height * data.scaleY);
         triangle.setRotate(data.angle);
         triangle.setFill(new Color(data.fillR, data.fillG, data.fillB, data.fillA));
         triangle.setStroke(triangle.getFill());
         triangle.setStrokeWidth(0);
         
         return triangle;
     }
 }
 