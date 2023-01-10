<template>
  <div>
    <h1>Edit Kudo Type</h1>
    <update-kudo-type v-bind:kudoTypeId="parseInt($route.params.id)" />
  </div>
</template>

<script>
import UpdateKudoType from "../components/UpdateKudoType.vue";
export default {
  components: { UpdateKudoType },
};
</script>

<style scoped>
</style>