//package org.soyphea.spring_boot3.config;
//
//import io.github.resilience4j.circuitbreaker.CircuitBreaker;
//import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;
//import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEventListener;
//
//public class CircuitBreakerStateListener implements CircuitBreakerEvent {
//
//    @Override
//    public void onEvent(CircuitBreakerEvent event) {
//        // Capture state transition events
//        if (event.getEventType() == CircuitBreakerEvent.Type.STATE_TRANSITION) {
//            CircuitBreaker.StateTransitionEvent stateEvent = (CircuitBreaker.StateTransitionEvent) event;
//            System.out.println("Circuit Breaker State Transition: " +
//                               stateEvent.getPreviousState() + " -> " + stateEvent.getNewState());
//        }
//    }
//}
