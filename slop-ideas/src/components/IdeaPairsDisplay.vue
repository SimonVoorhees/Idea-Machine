<script setup lang="ts">
import IdeaItem from './IdeaItem.vue'
const props = defineProps(['word', 'ideas'])
</script>
<template>
  <section class="IdeaPairsContainer">
    <IdeaItem class="IdeaPairsWord" :idea=word />
    <ul class="IdeaPairsList">
      <IdeaItem v-for="(idea, index) in ideas" :id="index" :idea="idea" class="IdeaPairsListItem" />
      <!-- <li v-for="idea in props.ideas" class="IdeaPairsListItem">{{ idea }}</li> -->
    </ul>
  </section>
</template>
<style>
.IdeaPairsContainer {
  background-color: var(--orange);
  display: flex;
  justify-content: center;
  border-radius: 28px;
}
.IdeaPairsWord {
  font-family: yokelvision-font;
  font-size: 72px;
  margin-left: 32px;
  list-style-type: none;
  height:128px;
}
.IdeaPairsList {
  overflow-x: hidden;
  overflow-y: scroll;
  height: 512px;
  list-style-type: none;
  margin-left: 0;
  padding: 0;
}
.IdeaPairsListItem {
  font-family: yokelvision-font;
  font-size: 72px;
  margin: 32px 0 64px 0;
}
.IdeaPairsList:first-child{
    margin-top:128px;
}
.IdeaPairsList:last-child{
    margin-bottom:128px;
}
</style>
