package com.studyall.study.temp;

public class Sync {

    private Resource resource;

    public Sync(String name) {
        this.resource = new Resource(name);
    }

    class Resource {
        private String name;

        public Resource(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println(name + " lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " unlock");
        }
    }

    public void executeInstanceLock(String name) {
        synchronized (this) {
            System.out.println(name + " thread lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " thread unlock");
        }
    }

    public void executeResourceInstanceLock(String name) {
        System.out.println(name + " method start");

        // resource 자원에 대해서 lock 을 건다 => resource 인스턴스에 대한 lock 을 얻어야 실행할 수 있는 로직이다.
        synchronized (resource) {
            System.out.println(name + " thread lock");
            resource.run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " thread unlock");
        }
    }

    public void executeClassLock(String name) {
        synchronized (Sync.class) {
            System.out.println(name + " thread lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " thread unlock");
        }
    }
}
