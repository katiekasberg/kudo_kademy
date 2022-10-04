<template>
  <div>
    <div class="parent-profile">
        <div>
          <parent-detail v-bind:parentId="parseInt($route.params.id)" />
        </div>
    </div>
  </div>
</template>

<script>
import ParentDetail from '../components/ParentDetail.vue'
export default {
  components: { ParentDetail },
  name: 'ParentProfile',


}
</script>

<style>

</style>