import {ref, Ref} from "vue";
import {ProductType} from "../interface/interfaces";

const productTypes: Ref<ProductType[]> = ref([
    ProductType.PANTS,
    ProductType.JACKETS,
    ProductType.ACCESSORIES,
    ProductType.VESTS,
    ProductType.RAINCOATS,
    ProductType.WINDSTOPPERS,
    ProductType.ALL])


export {
    productTypes
}