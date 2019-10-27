package estructuras;

public class ArbolString {
	 
    private String dato;
    private String referencia;
    private ArbolString izquierda;
    private ArbolString derecha;
    public ArbolString raiz;
 
    public ArbolString() {
        this.raiz = null;
        this.dato = "";
        this.referencia = "";
        this.izquierda = null;
        this.derecha = null;
    }
     
    public ArbolString(String dato, String referencia) {
        this.dato = dato;
        this.referencia = referencia;
        this.izquierda = null;
        this.derecha = null;
    }
 
    public void createTree( String content, String path ) {
       
        if( content != null ) {
            
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split( " " );
           
            for( int i = 0; i < words.length; i++ ) {
                this.addNode( words[i], path);
            }
        } 
        
    }
 
     
   
    public void addNode(String dato, String referencia) {
        if (this.dato == null) {
            this.dato = dato;
            this.referencia = referencia;
        } else {
            if (this.dato.compareTo(dato) > 0) {
                if (this.izquierda != null) {
                    this.izquierda.addNode(dato, referencia);
                } else {
                    this.izquierda = new ArbolString(dato, referencia);
                }
 
            } else {
                if (this.derecha != null) {
                    this.derecha.addNode(dato, referencia);
                } else {
                    this.derecha = new ArbolString(dato, referencia);
                }
 
            }
        }
    }
     
    public void traversePreOrder() {
        System.out.println(this.dato+" , "+this.referencia);
        if (this.izquierda != null) {
            this.izquierda.traversePreOrder();
        }
        if (this.derecha != null) {
            this.derecha.traversePreOrder();
        }
    }
 
    public void traverseInOrder() {
        if (this.izquierda != null) {
            this.izquierda.traverseInOrder();
        }
        System.out.println(this.dato+" , "+this.referencia);
        if (this.derecha != null) {
            this.derecha.traverseInOrder();
        }
    }
 
 
    public void traversePostOrder() {
        if (this.izquierda != null) {
            this.izquierda.traversePostOrder();
        }
        if (this.derecha != null) {
            this.derecha.traversePostOrder();
        }
        System.out.println(this.dato+" , "+this.referencia);
    }
    //public ArbolString nodo = new ArbolString();
    public String buscar(String llave){
       
       return buscarI(llave);
    
    }
    public  String buscarI(String str) {
        if(this.dato.equals(str)){
        	System.out.println(referencia + "  encontrada!!!");
            return referencia + "  encontrada!!!";
        }else if(str.compareTo(this.dato) < 0){
            return izquierda == null ? null:izquierda.buscarI(str);
        
        }else{
            return derecha == null ? null:derecha.buscarI(str);
        }
        
    }
    
    
     public static void main(String[] args) {
        /**
         * metodo principal
         * 
         * inserta y muestra
         */
        
        ArbolString Arbol = new ArbolString();
        Arbol.createTree("hola soy bb","hola.txt");
        Arbol.createTree("stella va a la playa","hola.pdf");
        Arbol.createTree("stella es mi waifu","hola.docx");
        Arbol.traversePreOrder();
        Arbol.buscar("stella");
    }
    
 
}