package dms.pastor.examples.java8.functional;


import dms.pastor.examples.java8.functional.supplier.NotRequiredDefaultImplementation;
import dms.pastor.examples.java8.functional.supplier.NotRequiredInterface;

final class SupplierRunner {

    public static void main(String[] args) {
        final NotRequiredInterface notRequiredInterface = NotRequiredInterface.create(NotRequiredDefaultImplementation::new);
        System.out.println(notRequiredInterface.notRequired());

        //       final NotRequiredInterface notRequiredInterfaceOverridden = NotRequiredInterface.create(NotRequiredOverriddenImplementation::new);
        //       System.out.println(notRequiredInterfaceOverridden.notRequired());

    }
}
