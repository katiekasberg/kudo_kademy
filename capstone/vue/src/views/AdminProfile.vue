<template>
  <div>
    <staff-detail v-bind:staffId="parseInt($route.params.id)" />
  </div>
</template>

<script>
import StaffDetail from "../components/StaffDetail.vue";
export default {
  components: { StaffDetail },
};
</script>

<style scoped>
</style>