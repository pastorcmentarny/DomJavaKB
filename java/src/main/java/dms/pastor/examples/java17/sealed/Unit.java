package dms.pastor.examples.java17.sealed;

sealed interface Unit permits Enemy,Player {
    String name();
}
