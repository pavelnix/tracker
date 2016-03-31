package ru.pavelnix;

/**
 *
 */
public class TrackerTest {
/*
    @Test
    public void addItemUseStartUI() {
        //Arrange
        Input input = new StubInput(new String[] {"name1"});
        Tracker tracker = new StartUITest(input).add();
        Item expectedItem = new Item("name1", "desc1", 0L, "author1");
        expectedItem.setId();
        Item[] expectedsItems = {new Item("name1", "desc1", 0L, "author1")};

        //Act
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);

    }

    @Test
    public void checkStateOfTrackerWhenAddCommentToItem() {
        //Arrange
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "desc1", 0L, "author1");
        tracker.add(item);
        Comment[] comments = {new Comment(item.getId(), "comment", 12l, "Pavel")};
        tracker.add(comments[0]);

        Comment[] expectedsComments = {comments[0]};

        //Act
        Item actualsItem = tracker.getById(item.getId());
        Comment[] actualsComments = actualsItem.getComments();

        //Assert
        assertArrayEquals(expectedsComments, actualsComments);
    }

    @Test
    public void checkStateOfTrackerWhenAddTwoCommentsToItem() {
        //Arrange
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "desc1", 0L, "author1");
        tracker.add(item);
        Comment[] comments = {new Comment(item.getId(), "comment", 12l, "Pavel"),
                new Comment(item.getId(), "comment1", 12l, "autor")};
        tracker.add(comments[0]);
        tracker.add(comments[1]);

        Comment[] expectedsComments = {comments[0], comments[1]};

        //Act
        Item actualsItem = tracker.getById(item.getId());
        Comment[] actualsComments = actualsItem.getComments();

        //Assert
        assertArrayEquals(expectedsComments, actualsComments);
    }

    @Test
    public void checkStateOfTrackerWhenAddItemAndSubItem() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Consultation("name2", "desc2", 0L, "author1", "question")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        Item[] expectedsItems = {item[0], item[1]};

        //Act
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }

    @Test
    public void checkStateOfTrackerWhenAddItem() {
        //Arrange
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "desc1", 0L, "author1");
        tracker.add(item);
        Item[] expectedsItems = {item};

        //Act
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }

    @Test
    public void checkStateOfTrackerWhenAddTwoItem() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Item("name2", "desc2", 0L, "author1")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        Item[] expectedsItems = {item[0], item[1]};

        //Act
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }

    @Test
    public void getItemByIdWhichIdExist() {
        //Arrange
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "desc1", 0L, "author1");
        tracker.add(item);
        String expectedId = item.getId();
        item = new Item("name2", "desc2", 0L, "author1");
        tracker.add(item);
        Item expectedItem = new Item("name1", "desc1", 0L, "author1");
        expectedItem.setId(expectedId);

        //Act
        Item actualItem = tracker.getById(expectedId);

        //Assert
        assertEquals(expectedItem, actualItem);
    }

    @Test
    public void getNullWhichIdNotExist() {
        //Arrange
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "desc1", 0L, "author1");
        tracker.add(item);
        String expectedId = "12345";
        item = new Item("name2", "desc2", 0L, "author1");
        tracker.add(item);
//        Item expectedItem = null;

        //Act
        Item actualItem = tracker.getById(expectedId);

        //Assert
        assertNull(actualItem);
    }

    @Test
    public void getItemByKey() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Item("name2", "desc2", 0L, "author1")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        Filter filter = new Filter();
        filter.setName("name1");
        filter.setDescription("desc");
        Item[] expectedsItems = {};

        //Act
        Item[] actualItems = tracker.findByKey(filter);

        //Assert
        assertArrayEquals(expectedsItems, actualItems);
    }

    @Test
    public void deleteFirstItemFromTracker() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Item("name2", "desc2", 0L, "author1"),
                new Item("name3", "desc3", 0L, "author3")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.add(item[2]);
        String idItemForDelete = item[0].getId();

        Item[] expectedsItems = {item[1], item[2]};

        //Act
        tracker.delete(idItemForDelete);
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }

    @Test
    public void deleteMiddleItemFromTracker() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Item("name2", "desc2", 0L, "author1"),
                new Item("name3", "desc3", 0L, "author3")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.add(item[2]);
        String idItemForDelete = item[1].getId();

        Item[] expectedsItems = {item[0], item[2]};

        //Act
        tracker.delete(idItemForDelete);
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }

    @Test
    public void deleteLastItemFromTracker() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Item("name2", "desc2", 0L, "author1"),
                new Item("name3", "desc3", 0L, "author3")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.add(item[2]);
        String idItemForDelete = item[2].getId();

        Item[] expectedsItems = {item[0], item[1]};

        //Act
        tracker.delete(idItemForDelete);
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }

    @Test
    public void deleteItemWhichNotExist() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Item("name2", "desc2", 0L, "author1"),
                new Item("name3", "desc3", 0L, "author3")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.add(item[2]);
        String idItemForDelete = "121111";

        Item[] expectedsItems = {item[0], item[1], item[2]};

        //Act
        tracker.delete(idItemForDelete);
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }

    @Test
    public void checkUpdateItem() {
        //Arrange
        Tracker tracker = new Tracker();
        Item[] item = {new Item("name1", "desc1", 0L, "author1"),
                new Item("name2", "desc2", 0L, "author1"),
                new Item("name3", "desc3", 0L, "author3")};
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.add(item[2]);
        String id = item[1].getId();
        Item updateItem = new Item("newname", "desc2", 0L, "author1");
        updateItem.setId(id);

        Item[] expectedsItems = {item[0], updateItem, item[2]};

        //Act
        tracker.update(updateItem);
        Item[] actualsItems = tracker.getAll();

        //Assert
        assertArrayEquals(expectedsItems, actualsItems);
    }
*/
}