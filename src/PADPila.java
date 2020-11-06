public class PADPila {

    Object pila1[];
    int cima=-1;

    public PADPila(int size) {
        pila1 = new Object[size];
    }

    public int apilar(Object o){
        if(cima>=pila1.length-1){
            System.out.println("la pila está llena");
        } else {
            cima+=1;
            pila1[cima] = o;
        }
        return cima;
    }

    public Object desapilar(){
        Object object = null;
        if(cima==-1){
            System.out.println("La pila esta vacia");
        }else{
            object = pila1[cima];
            pila1[cima]=null;
            cima-=1;
        }
        return object;
    }

    public void ver(){
        for(int i = pila1.length-1; i>=0; i--){
            System.out.println("Datos de la pila: "+pila1[i]);
        }
    }

    public int obtenerTamano() {
        return pila1.length;
    }
}