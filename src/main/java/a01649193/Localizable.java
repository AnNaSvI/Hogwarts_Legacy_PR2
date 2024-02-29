package a01649193;

public interface Localizable {
     void setOrigin(String origin);

     String getOrigin();
    default String getOriginFormatted(){
        return getOriginProcessType()+" "+getOrigin();
    }
    default String getOriginProcessType(){
        return "Made";
    }
}
