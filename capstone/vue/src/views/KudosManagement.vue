<template>
  <div class="container">
    <rewards />
    <new-kudo-type />
  </div>
</template>
 
<script>
import NewKudoType from "../components/NewKudoType.vue";
import Rewards from "../components/Rewards.vue";

export default {
  name: "KudosManagement",
  components: { NewKudoType, Rewards },
};
</script>
 
<style scoped>
.container {
  display: grid;
  align-content: center;
  margin-left: 300px;
  grid-template-rows: 1fr 1fr;
  width: 60%;
  justify-content: flex-start;
}
</style>