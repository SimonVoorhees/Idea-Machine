<script setup>
import IdeaItem from './IdeaItem.vue'
import { ref, reactive, onMounted, onUnmounted, toRef } from 'vue'
const props = defineProps(['group'])
const ideas = toRef(() => {
  let newObj = []
  for (let i = 0; i < props.group.ideas.length; i++) {
    newObj[i] = {
      idea: props.group.ideas[i],
      dragX: Math.random() * 200,
      dragY: Math.random() * 200,
    }
  }
  return reactive(newObj)
})

const isDragging = ref(false)
const mouseX = ref(0)
const mouseY = ref(0)

const dragStartX = ref(0)
const dragStartY = ref(0)

const startDrag = (event) => {
  isDragging.value = true
  if (event?.target?.id !== undefined) {
    dragStartX.value = event.clientX - ideas.value[Number(event.target.id)].dragX
    dragStartY.value = event.clientY - ideas.value[Number(event.target.id)].dragY
  } else if (event?.target?.parentElement?.id !== undefined) {
    dragStartX.value = event.clientX - ideas.value[Number(event.target.parentElement.id)].dragX
    dragStartY.value = event.clientY - ideas.value[Number(event.target.parentElement.id)].dragY
  }
  console.log(ideas.value[Number(event.target?.parentElement?.id)])
}
const handleDragMove = (event) => {
  if (isDragging.value) {
    if (event?.target?.id !== undefined) {
      ideas.value[Number(event.target.id)].dragX = event.clientX - dragStartX.value
      ideas.value[Number(event.target.id)].dragY = event.clientY - dragStartY.value
    } else if (event?.target?.parentElement?.id !== undefined) {
      ideas.value[Number(event.target.parentElement.id)].dragX = event.clientX - dragStartX.value
      ideas.value[Number(event.target.parentElement.id)].dragY = event.clientY - dragStartY.value
    }
  }
}

const stopDrag = () => {
  isDragging.value = false
}
onMounted(() => {
  window.addEventListener('mousemove', handleDragMove)
  window.addEventListener('mouseup', stopDrag)
})

onUnmounted(() => {
  window.removeEventListener('mousemove', handleDragMove)
  window.removeEventListener('mouseup', stopDrag)
})
</script>

<template>
  <!-- 
 -->
  <ul class="IdeaGroup">
    <IdeaItem v-for="(object, index) in ideas" :id="index" :idea="object.idea" />
    <!--
      @mousedown.left="startDrag"
      class="draggable" :style="{
        left: object.dragX + 'px',
        top: object.dragY + 'px',
      }" -->
  </ul>
</template>

<style>
.draggable {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: move;
  user-select: none;
}

.IdeaGroup {
  position: static;
  width: fit-content;
  background-color: var(--orange);
  color: var(--blue);
  border: 8px solid var(--blue);
  border-top: 8px solid var(--red);
  border-left: 8px solid var(--red);
  list-style: none;
  padding: 64px 64px 64px 36px;
  margin: 256px auto;
  font-size: 48px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  flex-wrap: wrap;
  gap: 12px;
  font-family: yokelvision-font;
}
.IdeaGroup:last-of-type {
  margin-bottom: 8px;
}
.IdeaGroup:first-of-type {
  margin-top: 32px;
}
</style>
