
the hexagonal architecture is an approach used to divide the application into inside and outside parts. They are connected through ports (exposed by the inside) and adapters (implemented by the outside). So, by applying this approach, the core use case code remains intact and can serve to multiple channels, supporting different protocols. It also helps to make the application tested easily. 


a confusion between event-driven and event-sourced architecture. In an event-driven architecture, components perform tasks in response to received events, and emit events to notify about changes in state. In event sourcing, state changes are recorded as events and the current state of an entity is calculated from all events related to the entity

If you’re not facing some kind of problem, you don’t need a new tool. Full stop.make sure that you’re choosing a technology because it solves real needs for you, not because the cool kids are doing it.https://www.simplethread.com/was-mongodb-ever-the-right-choice/