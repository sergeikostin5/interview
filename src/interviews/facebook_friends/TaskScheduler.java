package interviews.facebook_friends;

// We have a list of various types of tasks to perform. Task types are identified with an integral identifier: task
// of type 1, task of type 2, task of type 3, etc. Each task takes 1 time slot to execute, and once we have executed a
// task we need cooldown (parameter) time slots to recover before we can execute another task of the same type. However,
// we can execute tasks of other types in the meantime. The recovery interval is the same for all task types. We do not
// reorder the tasks: always execute in order in which we received them on input.
// Given a list of input tasks to run, and the cooldown interval, output the minimum number of time slots required
// to run them.


// Tasks: 1, 1, 2, 1
// Recovery interval (cooldown): 3
// Output: 7 (order is 1 _ _ 1 2 _ 1)
public class TaskScheduler {
}
