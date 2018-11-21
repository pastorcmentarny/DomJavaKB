package dms.pastor.examples.java8.functions;

import dms.pastor.kb.java8.functions.supplier.NotRequiredDefaultImplementation;
import dms.pastor.kb.java8.functions.supplier.NotRequiredInterface;
import dms.pastor.kb.java8.functions.supplier.NotRequiredOverridenImplementation;

final class SupplierRunner {

    public static void main(String[] args) {
        final NotRequiredInterface notRequiredInterface = NotRequiredInterface.create(NotRequiredDefaultImplementation::new);
        System.out.println(notRequiredInterface.notRequired());

        final NotRequiredInterface notRequiredInterfaceOverridden = NotRequiredInterface.create(NotRequiredOverridenImplementation::new);
        System.out.println(notRequiredInterfaceOverridden.notRequired());

    }
}
