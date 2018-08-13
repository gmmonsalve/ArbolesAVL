/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl_ejercicioestructurad2;

/**
 *
 * @author gmmonsalve
 */
public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    //Operaciones del arbol Binario
    public void insertar(Nodo raiz, int valor) {
        if (valor > raiz.getInfo()) {
            if (raiz.getDerecho() == null) {
                raiz.setDerecho(new Nodo(valor));
                System.out.println("acabo de crear el nodo" + valor + " a la derecha de " + raiz.getInfo());
            } else {
                insertar(raiz.getDerecho(), valor);
            }

        } else {
            if (valor < raiz.getInfo()) {
                if (raiz.getIzquierdo() == null) {
                    raiz.setIzquierdo(new Nodo(valor));
                    System.out.println("acabo de crear el nodo" + valor + " a la izquierda de " + raiz.getInfo());
                } else {
                    insertar(raiz.getIzquierdo(), valor);
                }

            }
        }
    }

    public static void busqueda(Nodo raiz, int valor) {
        if (valor == raiz.getInfo()) {
            System.out.println("¡Encontrado!");
        } else {
            if (valor > raiz.getInfo()) {
                busqueda(raiz.getDerecho(), valor);
            } else {
                if (valor < raiz.getInfo()) {
                    busqueda(raiz.getIzquierdo(), valor);

                }
            }

        }

    }

    //metodos de ordenamiento
    public static void Preorden(Nodo raiz) { //Método de ordenamiendo, PreOrden
        if (raiz != null) {
            System.out.println("" + raiz.getInfo());
            Preorden(raiz.getIzquierdo());
            Preorden(raiz.getDerecho());
        }
    }

    public static void InOrden(Nodo raiz) {
        if (raiz != null) {
            InOrden(raiz.getIzquierdo());
            System.out.println("!" + raiz.getInfo() + ")");
            InOrden(raiz.getDerecho());
        }
    }

    public static void PosOrden(Nodo raiz) {
        if (raiz != null) {
            PosOrden(raiz.getIzquierdo());
            PosOrden(raiz.getDerecho());
            System.out.println("!" + raiz.getInfo() + ")");
        }
    }
//operaciones específicas de Arbol AVL

    int getAltura(Nodo raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return (1 + Math.max(getAltura(raiz.getIzquierdo()), getAltura(raiz.getDerecho())));
        }
    }

    void setFactorBalance(Nodo raiz) {
        if (raiz != null) {
            raiz.setFactorBalance(getAltura(raiz.getDerecho()) - getAltura(raiz.getIzquierdo()));
        }
    }

    int getFactorBalance(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return raiz.getFactorBalance();
    }

    Nodo rotacionDerecha(Nodo raiz) {
        System.out.println("Rotación derecha lol");
        Nodo h = raiz.izquierdo;
        raiz.izquierdo = h.derecho;
        h.derecho = raiz;

        setFactorBalance(raiz);
        setFactorBalance(h);

        return h;
    }

    Nodo rotacionDobleDerecha(Nodo raiz) {
        raiz.izquierdo = rotacionIzquierda(raiz.izquierdo);
        return rotacionDerecha(raiz);
    }

    Nodo rotacionIzquierda(Nodo raiz) {
        System.out.println("Izquierda");
        Nodo h = raiz.derecho;
        raiz.derecho = h.izquierdo;
        h.izquierdo = raiz;

        setFactorBalance(raiz);
        setFactorBalance(h);

        return h;
    }

    Nodo rotacionDobleIzquierda(Nodo raiz) {
        raiz.derecho = rotacionDerecha(raiz.derecho);
        return rotacionIzquierda(raiz);
    }

   Nodo insertarAVL(Nodo nodo, int dato) {
       if (nodo == null)
            return (new Nodo(dato));
 
        if (dato < nodo.getInfo())
            nodo.izquierdo = insertarAVL(nodo.izquierdo, dato);
        else if (dato > nodo.getInfo())
            nodo.derecho = insertarAVL(nodo.derecho, dato);
        else 
            return nodo;
 
        setFactorBalance(nodo);
      
        if (getFactorBalance(nodo) == -2 && getFactorBalance(nodo.izquierdo)!=1)
            return rotacionDerecha(nodo);
 
        if (getFactorBalance(nodo) == 2 && getFactorBalance(nodo.derecho)!=-1)
            return rotacionIzquierda(nodo);
 
        if (getFactorBalance(nodo) == 2 && getFactorBalance(nodo.derecho)==-1) {
            return rotacionDobleIzquierda(nodo);
        }
        
        if (getFactorBalance(nodo) == -2 && getFactorBalance(nodo.izquierdo)==1) {
            return rotacionDobleDerecha(nodo);
        }
        
        return nodo;
    }
    }

