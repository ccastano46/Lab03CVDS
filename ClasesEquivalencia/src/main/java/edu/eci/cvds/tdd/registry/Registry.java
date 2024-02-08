package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
    private ArrayList<Integer> idRegistrados;
    public Registry(){
        idRegistrados = new ArrayList<>();
    }

    public RegisterResult registerVoter(Person p) {
        boolean duplicado = false;
        if(p.isAlive()){
            for(int i = 0; i < idRegistrados.size(); i++){
                if (p.getId() == idRegistrados.get(i)){
                    duplicado = true;
                    break;
                }
            }
            if(duplicado){
                return RegisterResult.DUPLICATED;
            }
            else if(p.getAge() >= 0 && p.getAge() < 18){
                return RegisterResult.UNDERAGE;
            }else if(p.getAge() < 0 || p.getAge() > 110 ){
                return RegisterResult.INVALID_AGE;
            }else{
                idRegistrados.add(p.getId());
                return RegisterResult.VALID;
            }
        }else{
            return RegisterResult.DEAD;
        }
       
        
        
    }
}
