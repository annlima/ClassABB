// Implementación del Árbol Binario de Búsqueda Balanceado (AVL)
class ABB {
    Nodo raiz; // Nodo raíz del árbol

    // Función para obtener la altura de un nodo
    int altura(Nodo N) {
        return (N == null) ? 0 : N.altura;
    }

    // Función para obtener el factor de equilibrio de un nodo
    int getBalance(Nodo N) {
        return (N == null) ? 0 : altura(N.izquierda) - altura(N.derecha);
    }

    // Rotación simple a la derecha
    Nodo rightRotate(Nodo y) {
        Nodo x = y.izquierda;
        Nodo T3 = x.derecha;

        // Realizar rotación
        x.derecha = y;
        y.izquierda = T3;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;  // Devolver nueva raíz tras rotación
    }

    // Rotación simple a la izquierda
    Nodo leftRotate(Nodo x) {
        Nodo y = x.derecha;
        Nodo T2 = y.izquierda;

        // Realizar rotación
        y.izquierda = x;
        x.derecha = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;  // Devolver nueva raíz tras rotación
    }   

    // Método público para insertar un aula en el árbol
    public void insert(int capacidad, String edificio,int salon, String descripcion, int pc, int proyector, int pizarron) {
        raiz = insertRec(raiz, new Aula(capacidad, edificio, salon, descripcion, pc, proyector, pizarron));
    }

    // Método público para asignar el aula más cercana a la capacidad de estudiantes solicitada
    public String assignAula(int capacidadEstudiantes, int pcaula, int proyectoraula, int pizarronaula) {
        Aula aulaEncontrada = findClosestMatch(raiz, capacidadEstudiantes, pcaula,proyectoraula, pizarronaula);
        if (aulaEncontrada != null) {
            // Si es necesario, aquí se pueden agregar actualizaciones al detalle del aula.
            return aulaEncontrada.descripcion;
        } else {
            return null;
        }
    }

    // Función recursiva para buscar el aula más cercana a la capacidad solicitada
    private Aula findClosestMatch(Nodo nodo, int capacidadEstudiantes, int pcaula, int proyectoraula, int pizarronaula) {
        if (nodo == null) return null;

        if (nodo.aula.capacidad == capacidadEstudiantes && nodo.aula.pc == pcaula && nodo.aula.proyector == proyectoraula && nodo.aula.pizarron == pizarronaula) {
            return nodo.aula;
        }

        if (nodo.aula.capacidad > capacidadEstudiantes) {
            Aula leftSearch = findClosestMatch(nodo.izquierda, capacidadEstudiantes, pcaula,proyectoraula, pizarronaula);
            return (leftSearch != null) ? leftSearch : nodo.aula;
        }

        return findClosestMatch(nodo.derecha, capacidadEstudiantes, pcaula,proyectoraula, pizarronaula);
    }
    // Función recursiva para insertar un nodo en el árbol AVL
    private Nodo insertRec(Nodo nodo, Aula aula) {
        // 1. Realizar inserción normal de ABB
        if (nodo == null) return new Nodo(aula);
        if (aula.capacidad < nodo.aula.capacidad) {
            nodo.izquierda = insertRec(nodo.izquierda, aula);
        } else if (aula.capacidad > nodo.aula.capacidad) {
            nodo.derecha = insertRec(nodo.derecha, aula);
        } else return nodo;  // No se permiten duplicados

        // 2. Actualizar altura del nodo padre
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));

        // 3. Obtener factor de equilibrio para verificar si se volvió desbalanceado
        int balance = getBalance(nodo);

        // 4. Realizar rotaciones para balancear el nodo
        // Rotación simple derecha (Left Left)
        if (balance > 1 && aula.capacidad < nodo.izquierda.aula.capacidad) {
            return rightRotate(nodo);
        }
        // Rotación simple izquierda (Right Right)
        if (balance < -1 && aula.capacidad > nodo.derecha.aula.capacidad) {
            return leftRotate(nodo);
        }
        // Rotación doble izquierda-derecha (Left Right)
        if (balance > 1 && aula.capacidad > nodo.izquierda.aula.capacidad) {
            nodo.izquierda = leftRotate(nodo.izquierda);
            return rightRotate(nodo);
        }
        // Rotación doble derecha-izquierda (Right Left)
        if (balance < -1 && aula.capacidad < nodo.derecha.aula.capacidad) {
            nodo.derecha = rightRotate(nodo.derecha);
            return leftRotate(nodo);
        }
        return nodo;
    }
    // Método público para encontrar y remover el aula más cercana a la capacidad solicitada
    public String findAndRemove(int capacidadEstudiantes, int pc, int proyector, int pizarron) {
        Aula aulaEncontrada = new Aula();
        raiz = findAndRemoveRec(raiz, capacidadEstudiantes, aulaEncontrada, pc, proyector, pizarron);
        return aulaEncontrada.descripcion;
    }
    // Función recursiva para buscar y eliminar el aula más cercana a la capacidad solicitada
    private Nodo findAndRemoveRec(Nodo nodo, int capacidadEstudiantes, Aula aulaEncontrada, int pc, int proyector, int pizarron) {
        if (nodo == null) return nodo; // no encontramos un aula que cumpla con la capacidad
        // Si encontramos un aula que tiene capacidad suficiente pero no es la más pequeña
        // Guardamos temporalmente y buscamos en el subárbol izquierdo por una mejor opción.
        if (nodo.aula.capacidad >= capacidadEstudiantes && nodo.aula.pc == pc && nodo.aula.proyector == proyector && nodo.aula.pizarron == pizarron) {
            aulaEncontrada.capacidad = nodo.aula.capacidad;
            aulaEncontrada.proyector = nodo.aula.proyector;
            aulaEncontrada.pc = nodo.aula.pc;
            aulaEncontrada.pizarron = nodo.aula.pizarron;
            nodo.izquierda = findAndRemoveRec(nodo.izquierda, capacidadEstudiantes, aulaEncontrada, pc, proyector, pizarron);
        } else {
            nodo.derecha = findAndRemoveRec(nodo.derecha, capacidadEstudiantes, aulaEncontrada, pc, proyector, pizarron);
        }

        // Si no encontramos ningún aula con suficiente capacidad, retornamos null.
        if (aulaEncontrada.descripcion == null) return nodo;

        // Si el nodo actual coincide con el aula encontrada, lo eliminamos.
        if (nodo.aula.capacidad == aulaEncontrada.capacidad) {
            // Casos de nodo con un hijo o sin hijos
            if ((nodo.izquierda == null) || (nodo.derecha == null)) {
                Nodo temp = null;
                if (temp == nodo.izquierda) temp = nodo.derecha;
                else temp = nodo.izquierda;

                // Caso sin hijos
                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else { // Caso con un hijo
                    nodo = temp;
                }
            } else {
                // Caso con dos hijos, buscamos el sucesor inorden
                nodo.aula = minValueNode(nodo.derecha).aula;
                nodo.derecha = findAndRemoveRec(nodo.derecha, nodo.aula.capacidad, new Aula(), nodo.aula.pc, nodo.aula.proyector, nodo.aula.pizarron);
            }
        }

        // Si no se encontró ningún aula para eliminar, retornamos el nodo.
        if (nodo == null) return nodo;

        // Actualizamos altura
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));

        // Verificamos el balanceo y rotamos si es necesario.
        int balance = getBalance(nodo);
        if (balance > 1 && getBalance(nodo.izquierda) >= 0) return rightRotate(nodo);
        if (balance > 1 && getBalance(nodo.izquierda) < 0) {
            nodo.izquierda = leftRotate(nodo.izquierda);
            return rightRotate(nodo);
        }
        if (balance < -1 && getBalance(nodo.derecha) <= 0) return leftRotate(nodo);
        if (balance < -1 && getBalance(nodo.derecha) > 0) {
            nodo.derecha = rightRotate(nodo.derecha);
            return leftRotate(nodo);
        }

        return nodo;
    }
    // Función para obtener el nodo con el menor valor (utilizado para la eliminación)
    private Nodo minValueNode(Nodo nodo) {
        Nodo current = nodo;
        while (current.izquierda != null) {
            current = current.izquierda;
        }
        return current;
    }

}
